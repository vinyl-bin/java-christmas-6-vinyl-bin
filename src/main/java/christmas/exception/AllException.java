package christmas.exception;

public class AllException {
    public int stringToInt(String str) {
        while(true) {
            try {
                int input = Integer.parseInt(str);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요");
            }
        }
    }
}
