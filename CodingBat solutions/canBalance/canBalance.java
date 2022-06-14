	public boolean canBalance(int[] nums) {
		  boolean   canBalance = false;
		  int       sumSide1   = 0;
		  int       sumSide2   = 0;
		  int       sum        = 0;
    
			for (int i=0;i<nums.length;i++){
			 sum+=nums[i];
			}
			for (int i=0;i<nums.length;i++){
				sumSide1+=nums[i];
			  sumSide2=sum-sumSide1;
			  
			  if (sumSide2==sumSide1){
			    return true;
			  }
			}return canBalance;

		}
