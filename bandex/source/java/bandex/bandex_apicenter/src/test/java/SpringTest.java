import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bandex.apicenter.service.RedisService;

public class SpringTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RedisService e = (RedisService) context.getBean("redisService");
		//
		// e.driverGeoAdd(1, 113.3579665, 23.1322215);
		//
		// e.driverGeoAdd(2, 113.363965, 23.136775);
		//
		// GeoResults<GeoLocation<Integer>> geoRet = e.driverGeoRadius(113.3565017, 23.1181103, 10000);
		// if (geoRet != null) {
		// System.out.println(geoRet.getContent().toString());
		// }

		// e.geoAdd("geo-list", "aaa", 113.3579665, 23.1322215);
		//
		// e.geoAdd("geo-list", "bbb", 113.363965, 23.136775);
		//
		// GeoResults<GeoLocation<String>> geoRet = e.geoRadius("geo-list", 113.3565017, 23.1181103, 1000);
		// if (geoRet != null) {
		// System.out.println(geoRet.getContent().toString());
		// }

		// e.set("1", "a");
		// System.out.println(e.get("1"));

		// e.push("1", "a");
		// System.out.println(e.pop("1"));

		// for (int i = 0; i < 100; i++) {
		// e.push("key" + i, "value" + i);
		// }

		// for (int i = 0; i < 100; i++) {
		// System.out.println(e.pop("key" + i));
		// }

		// for (int i = 0; i < 100; i++) {
		// Map<String, Object> msgMap = new HashMap<String, Object>();
		// msgMap.put("k" + i, "v" + i);
		// // e.sendMsg("ufopMessageChannel", msgMap);
		// e.sendUfopMsg(msgMap);
		// }

		// Map<String, Object> msgMap2 = new HashMap<String, Object>();
		// msgMap2.put("k2", "v2");
		// // e.sendMsg("cleanCacheMessageChannel", msgMap2);
		// e.sendCleanCacheMsg(msgMap2);
	}

}
