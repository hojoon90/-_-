package example.state;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState(){

    }
    public static State getInstance(){
        return singleton;
    }
    public void doClock (Context context, int hour){
        if(hour < 9 || 17 <= hour){
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(Context context){
        context.recordLog("금고사용 (주간)");
    }
    public void doAlarm(Context context){
        context.callSecurityCenter("비상벨 (주간)");
    }
    public void doPhone(Context context){
        context.callSecurityCenter("일반통화 (주간)");
    }
    public String toString(){
        return "[주간]";
    }
}
