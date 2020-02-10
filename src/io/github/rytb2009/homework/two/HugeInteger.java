package io.github.rytb2009.homework.two;

import java.util.Collections;
import java.util.Deque;
import java.util.Vector;

public class HugeInteger {
    private int signNum; // non-negative (0) or negative (1).
    private Vector<Integer> digits = new Vector<>();

    public HugeInteger() {

    }

    public HugeInteger(String s) {
        parse(s);
    }

    public void parse(String s) {
        if (s == null || s.trim().length() == 0) {
            return;
        }
        if (s.startsWith("-")) {
            this.signNum = 1;
            s = s.substring(1);
        }
        s = s.replaceFirst("^0+(?!$)", ""); // remove leading 0s
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digits.add(Character.getNumericValue(c));
            }
        }
    }

    public String toString() {
        if (isZero()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (signNum == 1) {
            sb.append("-");
        }
        for(Integer i: digits) {
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }

    // if two numbers have the same sign, do addition;
    // if two numbers have different signs, turn the negative one into positive and do subtraction
    // eg. 20 + (-30) = 20 - 30 or (-20) + 30 = 30 - 20
    public HugeInteger add(HugeInteger hi) {
        if (this.signNum != hi.signNum) {
            HugeInteger positiveNum = this.signNum == 0 ? this : hi;
            HugeInteger negativeNum = this.signNum == 0 ? hi : this;
            HugeInteger negativeNumBuff = new HugeInteger(negativeNum.toString());
            negativeNumBuff.signNum = 0;
            return positiveNum.subtract(negativeNumBuff);
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int thisCount = this.digits.size();
        int hiCount = hi.digits.size();
        while (thisCount >= 0 || hiCount >= 0) {
            int thisNum = Math.abs(getNumValue(this, thisCount - 1));
            int hiNum = Math.abs(getNumValue(hi, hiCount - 1));
            int sum = thisNum + hiNum + carry;
            carry = sum >= 10 ? 1 : 0;
            sb.append(sum % 10);
            thisCount--;
            hiCount--;
        }
        HugeInteger newHi = new HugeInteger(sb.reverse().toString());
        newHi.signNum = this.signNum;
        return newHi;
    }

    // if two numbers have the same sign, do subtraction;
    // if two numbers have different signs, make it the same sign and do addition.
    // eg. 20 - (-30) = 20 + 30 or (-20) - 30 = (-20) + (-30)
    public HugeInteger subtract(HugeInteger hi) {
        if (this.signNum != hi.signNum) {
            HugeInteger hiBuff = new HugeInteger(hi.toString());
            hiBuff.signNum = this.signNum;
            return add(hiBuff);
        }
        boolean thisIsGreater = this.isGreaterThan(hi);
        HugeInteger greaterNum = thisIsGreater ? this : hi;
        HugeInteger smallerNum = thisIsGreater ? hi : this;
        StringBuilder sb = new StringBuilder();
        int borrow = 0;
        int greaterNumCount = greaterNum.digits.size();
        int smallerNumCount = smallerNum.digits.size();
        while (greaterNumCount >= 0 || smallerNumCount >= 0) {
            int greaterNumVal = getNumValue(greaterNum, greaterNumCount - 1);
            int smallerNumVal = getNumValue(smallerNum, smallerNumCount - 1);
            int sum = (greaterNumVal + 10) - smallerNumVal - borrow;
            borrow = greaterNumVal < smallerNumVal ? 1 : 0;
            sb.append(Math.abs(sum) % 10);
            greaterNumCount--;
            smallerNumCount--;
        }
        HugeInteger newHi = new HugeInteger(sb.reverse().toString());
        newHi.signNum = thisIsGreater ? 0 : 1;
        return newHi;
    }

    private int getNumValue(HugeInteger hi, int index) {
        if (index < 0 || index > hi.digits.size() - 1) {
            return 0;
        }
        int value = hi.digits.get(index);
        return hi.signNum == 1 ? value * -1 : value;
    }

    public boolean isZero() {
        return digits.size() == 1 && digits.get(0) == 0;
    }

    public boolean isEqualTo(HugeInteger hi) {
        return hi != null && this.digits.equals(hi.digits) && this.signNum == hi.signNum;
    }

    public boolean isNotEqualTo(HugeInteger hi) {
        return !isEqualTo(hi);
    }

    public boolean isGreaterThan(HugeInteger hi) {
        if (isEqualTo(hi)) {
            return false;
        }
        if (this.signNum == hi.signNum) {
            if (this.digits.size() == hi.digits.size()) {
                for (int i = this.digits.size() - 1; i >= 0; i--) {
                    int thisNum = this.digits.get(i);
                    int hiNum = hi.digits.get(i);
                    if (thisNum == hiNum) {
                        continue;
                    }
                    return thisNum > hiNum;
                }
            }
            return this.signNum == 1 ? this.digits.size() < hi.digits.size() : this.digits.size() > hi.digits.size();
        }
        return this.signNum < hi.signNum;
    }

    public boolean isLessThan(HugeInteger hi) {
        return isNotEqualTo(hi) && !isGreaterThan(hi);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger hi) {
        return isEqualTo(hi) || isGreaterThan(hi);
    }

    public boolean isLessThanOrEqualTo(HugeInteger hi) {
        return isEqualTo(hi) || isLessThan(hi);
    }
}
