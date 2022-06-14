public Map<String, Boolean> wordMultiple(String[] strings) {
  
  
  HashMap<String, Boolean> hm=new HashMap<String, Boolean>();
  
		for (int i=0;i<strings.length;i++) {
      
			String key=strings[i];
      
			if(!(hm.keySet().contains(key))) {
        
				boolean bool=false;
        
				for(int j=0;j<strings.length;j++) {
          
					if(j!=i && strings[j]==key) {         
						hm.put(key, true);           
						break;
					}
          
					hm.put(key, false);
				}
			}
      
		}
  
		return hm;
}
