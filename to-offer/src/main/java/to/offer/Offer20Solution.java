package to.offer;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.HashMap;
import java.util.Map;

/***
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class Offer20Solution {

    public static void main(String[] args) {
        //基础验证
        double a = 1e6;
        System.out.println(a);
    }

    /**
     * 方法1：确定有限状态机
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        //定义确定有限状态机
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        Map<CharType, State> initialMap = new HashMap<>();
        initialMap.put(CharType.CHAR_SPACE, State.STATE_INITIAL);
        initialMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        initialMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        initialMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        transfer.put(State.STATE_INITIAL, initialMap);

        Map<CharType, State> intSignMap = new HashMap<>();
        intSignMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intSignMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        Map<CharType, State> integerMap = new HashMap<>();
        integerMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        integerMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        integerMap.put(CharType.CHAR_SPACE, State.STATE_END);
        integerMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_INTEGER, integerMap);

        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_SPACE, State.STATE_END);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_POINT, pointMap);

        Map<CharType, State> pointWithoutInt = new HashMap<>();
        pointWithoutInt.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutInt);

        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        fractionMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_FRACTION, fractionMap);

        Map<CharType, State> expMap = new HashMap<>();
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP, expMap);

        Map<CharType, State> expSignMap = new HashMap<>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        Map<CharType, State> expNumMap = new HashMap<>();
        expNumMap.put(CharType.CHAR_SPACE, State.STATE_END);
        expNumMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_NUMBER, expNumMap);

        Map<CharType, State> endMap = new HashMap<>();
        endMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_END, endMap);


        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER
                || state == State.STATE_POINT
                || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUMBER
                || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    //定义状态机状态类型
    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END,
    }

    //定义状态机转移因子类型
    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL,
    }
}
