package 求子集;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	//将数组中的元素放入TreeSet中
	public static TreeSet<Integer> initData(int[] temp) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0;i<temp.length;i++) {
			set.add(temp[i]);
		}
		return set;
	}
	//根据集合的个数构造二进制字符串
	public static String[] getBinaryString(Set<Integer> set) {
		int num = set.size();
		System.out.println("num="+num);
		int size = (int)Math.pow(2, num);
		String[] result = new String[size];
		for(int i=0;i<size;i++) {
			StringBuffer sbf = new StringBuffer(Integer.toBinaryString(i));
			while(sbf.length()<num) {
				sbf.insert(0, "0");
			}
			result[i] = sbf.toString();
			System.out.println("i="+result[i]);
		}
		return result;
	}
	//生成子集
	public static ArrayList<TreeSet<Integer>> getSubSet(TreeSet<Integer> set,String[] result) {
		ArrayList<TreeSet<Integer>> list = new ArrayList<>();
		int[] items = new int[set.size()];
		int i = 0;
		for(int ele:set) {
			items[i++] = ele;
		}
		TreeSet<Integer> s = null;
		for(i=1;i<result.length;i++) {
			s = new TreeSet<>();
			for(int j=0;j<=set.size()-1;j++) {
				if(result[i].charAt(j)=='1') {
					s.add(items[j]);
				}
			}
			list.add(s);
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n_str = sc.nextLine();
		int n = Integer.parseInt(n_str);//集合元素的个数
		String e_str = sc.nextLine();
		String[] temp = e_str.split(" ");
		int[] ele = new int[n];
		//数字类型的集合
		for(int i=0;i<n;i++) {
			ele[i] = Integer.parseInt(temp[i]);
		}
		TreeSet<Integer> set =  initData(ele);
		String[] result = getBinaryString(set);
		ArrayList<TreeSet<Integer>> list = getSubSet(set,result);
		for(int i=0;i<list.size();i++) {
			TreeSet<Integer> s = list.get(i);
			System.out.println(s.toString());
		}
	}
}
