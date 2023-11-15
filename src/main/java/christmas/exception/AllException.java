package christmas.exception;

public class AllException {

    private final int FIRST_DAY = 0;
    private final int LAST_DAY = 31;


    public int stringToIntDate(String str) {
        boolean isCorrect = false;
        int input = 0;

        while(!isCorrect) {
            try {
                input = Integer.parseInt(str);
                isCorrect = isDate(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return input;
    }

    private boolean isDate(int input) {
        while(true) {
            if(input > FIRST_DAY && input <= LAST_DAY) {
                return true;
            }
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int stringToIntMenu(String str) {
        try {
            int input = Integer.parseInt(str);
            return input;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 입력양식이 틀렸습니다.");
        }
    }

}
