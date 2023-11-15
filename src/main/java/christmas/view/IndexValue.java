package christmas.view;

import java.util.Arrays;
import java.util.List;

public enum IndexValue {
    /** 인덱스 값 **/
    SALE_LIST(Arrays.asList("크리스마스 디데이 할인", "평일 할인", "주말 할인", "특별 할인", "증정 이벤트"));

    public final List<String> value;

    IndexValue(List<String> value) {
        this.value = value;
    }
}
