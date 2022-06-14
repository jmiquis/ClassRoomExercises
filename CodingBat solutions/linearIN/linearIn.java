public boolean linearIn(int[] outer, int[] inner) {
  int repeated=0;
  for(int i=0;i<inner.length;i++){
    for(int j=0;j<outer.length;j++){
      if (inner[i]==outer[j]){
        repeated++;break;
      }
    }
  }return (repeated==inner.length);
}
