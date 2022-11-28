package yucatio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapCount {
	public static void main(String args[])  {
		// new Employee(名前、部署、性別)
		List<Employee> employee = new ArrayList<>();  

		employee.add(new Employee("yucatio"    , "情報システム部"      ,"F")); 
		employee.add(new Employee("ハル"       , "情報システム部"      ,"M")); 
		employee.add(new Employee("saito_san"  , "情報システム部"      ,"M")); 
		employee.add(new Employee("山葵"       , "情報システム部"      ,"F")); 
		employee.add(new Employee("けこ"       , "情報システム部"      ,"F")); 
		employee.add(new Employee("fengla"     , "情報システム部"      ,"F")); 
		employee.add(new Employee("麻生"       , "情報システム部"      ,"M")); 
		employee.add(new Employee("bata"       , "情報システム部"      ,"M")); 
		employee.add(new Employee("市川"       , "情報システム部"      ,"M")); 
		employee.add(new Employee("ちか"       , "情報システム部"      ,"M")); 
		employee.add(new Employee("Hayashi"    , "情報セキュリティー部","M")); 
		employee.add(new Employee("astraea"    , "情報セキュリティー部","M")); 
		employee.add(new Employee("菅原鮮魚店" , "情報セキュリティー部","M")); 
		employee.add(new Employee("M.Pentes"   , "情報セキュリティー部","M")); 
		employee.add(new Employee("LOST_CANYON", "登山研究部"          ,"M")); 
		employee.add(new Employee("zero"       , "登山研究部"          ,"M")); 
		employee.add(new Employee("FLASH"      , "登山研究部"          ,"F")); 


		//		for (Employee e:employee) {
		//			System.out.println(e);
		//		}

		// stream を使わない実装	
		Map<String, Integer> countMap = countBySection(employee);

	}

	// 部署n種類のgroupingBy(stream を使わない実装)
	private static Map<String, Integer> countBySection(List<Employee> employee) {
		Map<String, Integer> map = new HashMap<>();
		int numOfemp = 0;
		for (Employee e:employee) {
			if(map.containsKey(e.getSection())) {
				map.replace(e.getSection(),   numOfemp++   );
			}else{
				map.put(e.getSection(),   numOfemp = 1   );
			}
		}
		map.forEach((key, val) -> System.out.println(key + " : " + val));
		return map;
	}
}
/*	
    // stream を使わない実装	
	private static Map<String, Integer> countBySection(List<Employee> employee) {
		Map<String, Integer> map = new HashMap<>();
		for (Entry<String,Integer> entryMap:List<Employee> employee.entrySet()) {



			System.out.println(entryMap.getKey() + ":" + entryMap.getValue());
		}
		return map;
	}
}
 */

/*
		// stream での実装
		Map<String, Long> countMap = employee
				.stream()
				.collect(Collectors.groupingBy(Employee::getSection,
						Collectors.counting()));
		for(Entry<String, Integer> map: countMap.entrySet()) {
			System.out.println(map.getKey() + " :" + map.getValue());
		}
 */


/*
	private static Map<String, Integer> countBySection(List<Employee> employee) {
		Map<String, Integer> map = new HashMap<>();

		int x = 0;
		int y = 0;
		int z = 0;
		for (Employee e: employee){
			switch (e.getSection()) {
			case "情報システム部":
				x++;
				break;
			case "情報セキュリティー部":
				y++;
				break;
			case "登山研究部":
				z++;
				break;
			default:
				break;
			}
		}
		map.put("情報システム部",x);
		map.put("情報セキュリティー部",y);
		map.put("登山研究部",z);
	//	map.forEach((key, val) -> System.out.println(key + " : " + val));
		return map;
	}

}
 */