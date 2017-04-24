package TCRealEstate;

public enum Condition {
  E("Excellent"), F("Fair"),G("Good"),N("New"),P("Poor");
  private String desc;
  
  private Condition(String condition){
	  desc = condition;
  }
  
  public String getCondition(){
	  return desc;
  }
}
