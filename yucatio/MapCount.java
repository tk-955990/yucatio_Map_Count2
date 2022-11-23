package yucatio;

import java.util.ArrayList;
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


		for (Employee e:employee) {
			System.out.println(e);
		}

		Map<String, Integer> countMap = countBySection(employee);
		
		for (Entry<String,Integer> map:countMap.entrySet()) {
			System.out.println(map.getKey() + ":" + map.getValue());
			}
		/*
		// stream での実装

		Map<String, Long> countMap = employee
				.stream()
				.collect(Collectors.groupingBy(Employee::getSection,
						Collectors.counting()));
		for(Entry<String, Long> map: countMap.entrySet()) {
			System.out.println(map.getKey() + " :" + map.getValue());
		}
		 */	 

	}

	// stream を使わない実装	

	private static Map<String, Integer>
	countBySection(List<Employee> employee) {
		Map<String, Integer> map = new HashMap<>();

		/*		Counter<Integer> c = new Counter<>();
        for (int v : employee) {
            c.add(v);
        }
        for (Integer i : c.keySet()) {
            System.out.println(i + ":cnt=" + c.get(i));
        }
		 */		
		for (Employee e:employee) {
			// TODO ここを実装
			if (map.containsKey("情報システム部")) {
				int x = map.get("情報システム部");
				System.out.println("情報システム部:" + x );
			}
			if (map.containsKey("情報セキュリティー部 ")) {
				int y = map.get("情報セキュリティー部");
				System.out.println("情報セキュリティー部:" + y);
			}
			if (map.containsKey("登山研究部 ")) {
				int z = map.get("登山研究部");
				System.out.println("登山研究部: " + z);
			}
		}
		return map;
	}
}