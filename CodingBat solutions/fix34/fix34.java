public int[] fix34(int[] nums) {
  int aux=0;
		int fourPosition=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==3) {
				for(int j=fourPosition+1;j<nums.length;j++) {
					if(nums[j]==4 && j!=fourPosition) {
						fourPosition=j;
						aux=nums[i+1];
						nums[i+1]=4;
						nums[fourPosition]=aux;
						break;
					}
					
				}
				
			}
		}
		return nums;
	}
