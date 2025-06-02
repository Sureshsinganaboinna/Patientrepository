package com.itc.restclient.pojo;

import lombok.Data;

@Data
public class ApiCallResponseData {
	
	//{ip=49.37.128.247, city=Hyderābād, region=Telangana, country=IN, loc=17.3840,78.4564,
	//org=AS55836 Reliance Jio Infocomm Limited, postal=500001, timezone=Asia/Kolkata, readme=https://ipinfo.io/missingauth}

      public String ip;
      public String city;
      public String region;
      public String country;
      public String loc;
      public String org;
      public String postal;
      public String timezone;
      public String readme;
}
