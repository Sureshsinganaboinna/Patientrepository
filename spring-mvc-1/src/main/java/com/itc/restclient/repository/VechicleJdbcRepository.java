package com.itc.restclient.repository;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Vechicle;


@Repository
public class VechicleJdbcRepository {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	//The mapRow method is overridden from the RowMapper interface. It takes two parameters:

	//	ResultSet rs: The ResultSet object containing the results of a SQL query.
	//	int rowNum: The number of the current row (starting from 0).
	static class VechicleRowMap implements RowMapper<Vechicle>
	{
		@Override
		public Vechicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Vechicle vechicle = new Vechicle();
			vechicle.setBrand(rs.getString("brand"));
			vechicle.setModel(rs.getString("model"));
			vechicle.setTrim(rs.getString("trim"));
			vechicle.setYear(rs.getInt("year"));
			vechicle.setVechicleid(rs.getInt("vechicleid"));
			
			return vechicle;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public List<Vechicle> vechicleSearchApi(int year,String brand, String model, String trim )
	{
	StringBuilder sqlquerybuilder = new StringBuilder("Select * from vechicles where ");
	// System.out.println(sqlquerybuilder.toString());
	
	List<Object> paramList2 = new ArrayList<Object>();
			
	int NoofConditiona = 0;
	 
	if(year!=0)
	{
	
	sqlquerybuilder.append("year = ? ");
	paramList2.add(year);
	NoofConditiona = NoofConditiona+1;
	}
//	System.out.println(sqlquerybuilder.toString());
	if(brand!=null)
	{
		if(NoofConditiona == 0)
		{
			sqlquerybuilder.append(" brand = ? ");
		}
		else {
			   sqlquerybuilder.append(" and brand = ? ");
			
		}
		NoofConditiona = NoofConditiona+1;
		paramList2.add(brand);
	   
	}
//	System.out.println(sqlquerybuilder.toString());
	
	if(model!=null)
	{
		if(NoofConditiona == 0)
		{
			sqlquerybuilder.append(" model = ? ");
		}
		else {
			sqlquerybuilder.append(" and model = ? ");
		}
		
		NoofConditiona = NoofConditiona+1;
		paramList2.add(model);
	}
//	System.out.println(sqlquerybuilder.toString());
	
	if(trim!=null)
	{
		if(NoofConditiona ==0)
		{
	sqlquerybuilder.append(" trim = ?");
	}else {
		sqlquerybuilder.append(" and trim = ? ");
	}
		paramList2.add(trim);
	}
	System.out.println(sqlquerybuilder.toString());
	System.out.println(paramList2);
	List<Vechicle>  vechicless  = jdbcTemplate.query(sqlquerybuilder.toString(), paramList2.toArray(), new VechicleRowMap());
	System.out.println(vechicless);
	return vechicless; 
	}
}
