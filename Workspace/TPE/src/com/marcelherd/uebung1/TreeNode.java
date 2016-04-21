package com.marcelherd.uebung1;

public class TreeNode implements Comparable<Integer>{

	private Integer[] values;
	private int valueCounter = 0;
	private int magnitude;
	
	public TreeNode(int magnitude) {
		this.magnitude = magnitude;
		values = new Integer[magnitude*2];
		
		
	}
	
	public void insert(Integer value){
		values[valueCounter] = value;
		valueCounter++;
	}
	
	public boolean contains(Integer value){
		for(int i = 0; i<values.length; i++){
			if(value.compareTo(values[i])==0){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Integer value) {
		if(values[values.length-1].compareTo(value) > 0){
			return 1;
		}else if(values[values.length-1].compareTo(value) < 0){
			return -1;
		}
		return 0;
	}
	
	public int size(){
		int retval = 0;
		for(int i = 0; i<values.length; i++){
			if(values[i] != null){
				retval++;
			}
		}
		return retval;
	}
	
	public int getMax(){
		int retval = values[0];
		for(int i = 1; i<values.length; i++){
			if(values[i] != null){
				retval = values[i];
			}else{
				break;
			}
		}
		return retval;
	}
	
	public int getMin(){
		return values[0];
	}
	
	public boolean isEmpty(){
		if(values[0] == null){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String retval = "";
		for(int i = 0; i<values.length-1; i++){
			retval += values[i] + " | ";
		}
		retval += values[values.length-1];
		return retval;
	}


	

}
