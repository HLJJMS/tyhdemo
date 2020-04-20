package wlm.diyview;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import java.util.regex.Pattern;

public class IDCardEditText extends AppCompatEditText {
    Pattern number;
    Pattern endNumber;

    public IDCardEditText(Context context) {
        super(context);
        number = Pattern.compile("^[0-9]$");
        endNumber = Pattern.compile("^[x0-9X]$");
    }

    public IDCardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IDCardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setFilters(InputFilter[] filters) {
        filters = new InputFilter[]{
                new InputFilter() {
                    /**
                     * @param source 输入的文字
                     * @param start  输入-0，删除-0
                     * @param end    输入-文字的长度，删除-0
                     * @param dest   原先显示的内容
                     * @param dstart 输入-原光标位置，删除-光标删除结束位置
                     * @param dend   输入-原光标位置，删除-光标删除开始位置
                     * @return
                     */
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        String sourceContent = source.toString();
                        if (dstart < 17 && number.matcher(sourceContent).matches()) {
                            return sourceContent;
                        } else if (dstart == 17 && endNumber.matcher(sourceContent).matches()) {
                            if (sourceContent.equals("x")) {
                                return "X";
                            } else {
                                return sourceContent;
                            }
                        } else {
                            return "";
                        }
                    }
                }
        };
        super.setFilters(filters);
    }
}
