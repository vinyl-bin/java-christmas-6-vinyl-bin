package christmas.exception;

public class AllException {
    public int stringToIntDate(String str) {
        while(true) {
            try {
                int input = Integer.parseInt(str);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요");
            }
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
