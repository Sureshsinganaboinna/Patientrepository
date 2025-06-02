package com.itc.restclient.repository;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Vechi;





@Repository
public class VechiRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static class VechicleRowMap implements RowMapper<Vechi>{

		@Override
		public Vechi mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vechi mapeachdatabaserowtoobjectVechi = new Vechi();
			mapeachdatabaserowtoobjectVechi.setVechiId(rs.getInt("vechi_id"));
			mapeachdatabaserowtoobjectVechi.setBrandName(rs.getString("brand_name"));
			mapeachdatabaserowtoobjectVechi.setModelName(rs.getString("model_name"));
			mapeachdatabaserowtoobjectVechi.setTrimName(rs.getNString("trim_name"));
			mapeachdatabaserowtoobjectVechi.setVechicleName(rs.getString("vechicle_name"));
			return mapeachdatabaserowtoobjectVechi;
		}
		
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public List<Vechi> vechicleDataFromDatabase(String brandname, String modelname,String trimname,String vechname)
	{
		StringBuilder sqlquery = new StringBuilder("select * from vechis_records where ");
		
		ArrayList<String> paramList = new ArrayList<String>();
		
		int nofcondition = 0;
		
		if(brandname!=null)
		{
			sqlquery.append("brand_name = ?");
		
			paramList.add(brandname);
			nofcondition = nofcondition+1;
		}
		if(modelname != null)
		{
			if( nofcondition == 0) {
				sqlquery.append("model_name = ?");
		
			}
			else {
				sqlquery.append("  and model_name = ?");
				
			}
		
			paramList.add(modelname);
			nofcondition = nofcondition+1;
			
		}
		if(trimname != null)
		{
			if( nofcondition == 0)
			{
				sqlquery.append("trim_name = ?");
	
			}
			else {
				sqlquery.append("  and trim_name = ?");
				
			}
			paramList.add(trimname);
			nofcondition = nofcondition+1;
		
		}
		if(vechname != null)
		{
			if(nofcondition == 0)
			{
				sqlquery.append("vechicle_name = ?");
			
			}
			else {
				sqlquery.append("  and vechicle_name = ?");
				
			}
			paramList.add(vechname);
			nofcondition = nofcondition+1;
			
		}
		
		System.out.println(sqlquery.toString());
		System.out.println(paramList);
	List<Vechi> respponseDataList =	jdbcTemplate.query(sqlquery.toString(), paramList.toArray(), new VechicleRowMap());
	
		System.out.println(respponseDataList);
		return respponseDataList;
	}
	
	
	
	
	
}
