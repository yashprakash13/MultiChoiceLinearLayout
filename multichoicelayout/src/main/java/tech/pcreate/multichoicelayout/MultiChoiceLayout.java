package tech.pcreate.multichoicelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MultiChoiceLayout extends LinearLayout implements View.OnClickListener {

    //Choices of Background
    public static final int STROKE = 1;
    public static final int SOLID = 2;

    //Option TextViews
    private TextView o1;
    private TextView o2;
    private TextView o3;
    private TextView o4;

    //Default Ignore Values
    private boolean ignore2, ignore3, ignore4;

    //separators between options
    private View separator1, separator2, separator3;

    //main layout
    private LinearLayout linearLayout;

    //user selection marker
    private static int selection = 0;

    private MultiChoiceOnclick multiChoiceOnclick;
    private TypedArray typedArray;

    public MultiChoiceLayout(Context context) {
        super(context);
        init(context);
    }

    public MultiChoiceLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setAttributes(context, attrs);
    }

    public MultiChoiceLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.multi_choice_layout, this);

        linearLayout = findViewById(R.id.multichoicelinearlayout);

        o1 = findViewById(R.id.opt1);
        o2 = findViewById(R.id.opt2);
        o3 = findViewById(R.id.opt3);
        o4 = findViewById(R.id.opt4);

        separator1 = findViewById(R.id.separator1);
        separator2 = findViewById(R.id.separator2);
        separator3 = findViewById(R.id.separator3);
    }

    private void setAttributes(Context context, AttributeSet attrs) {

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiChoiceLayout);

        o1.setText(typedArray.getText(R.styleable.MultiChoiceLayout_opt1));
        o1.setTextColor(typedArray.getColor(R.styleable.MultiChoiceLayout_opt1TColor, 0));
        o1.setOnClickListener(this);

        o2.setText(typedArray.getText(R.styleable.MultiChoiceLayout_opt2));
        o2.setTextColor(typedArray.getColor(R.styleable.MultiChoiceLayout_opt2TColor, 0));
        o2.setOnClickListener(this);

        o3.setText(typedArray.getText(R.styleable.MultiChoiceLayout_opt3));
        o3.setTextColor(typedArray.getColor(R.styleable.MultiChoiceLayout_opt3TColor, 0));
        o3.setOnClickListener(this);

        o4.setText(typedArray.getText(R.styleable.MultiChoiceLayout_opt4));
        o4.setTextColor(typedArray.getColor(R.styleable.MultiChoiceLayout_opt4TColor, 0));
        o4.setOnClickListener(this);

        ignore2 = typedArray.getBoolean(R.styleable.MultiChoiceLayout_ignoreSecond, false);
        ignore3 = typedArray.getBoolean(R.styleable.MultiChoiceLayout_ignoreThird, false);
        ignore4 = typedArray.getBoolean(R.styleable.MultiChoiceLayout_ignoreFourth, false);

        setViewVisibilities(ignore2, ignore3, ignore4);

        int color = typedArray.getColor(R.styleable.MultiChoiceLayout_backgroundColor, 0);
        int width  = typedArray.getInteger(R.styleable.MultiChoiceLayout_backStrokeWidth, 0);
        int backType =typedArray.getInt(R.styleable.MultiChoiceLayout_backType, 1);
        setBackground(color, width, backType);

        int colorSelectedBack = typedArray.getColor(R.styleable.MultiChoiceLayout_selectedOptionBackground, 0);
        if (colorSelectedBack != 0) setSelectedBackgroundColor(colorSelectedBack);

        typedArray.recycle();
    }

    public MultiChoiceLayout setSelectedBackgroundColor(int colorSelectedBack) {
        GradientDrawable drawable = (GradientDrawable) getResources().getDrawable(R.drawable.colorback_textview_background);
        drawable.setColor(colorSelectedBack);
        return this;
    }

    private void setViewVisibilities(boolean ignore2, boolean ignore3, boolean ignore4) {
        if (ignore4 && !ignore2 && !ignore3){
            o4.setVisibility(GONE); separator3.setVisibility(GONE);
        }
        else if(ignore3 && ignore4 && !ignore2){
            o4.setVisibility(GONE); separator3.setVisibility(GONE);
            o3.setVisibility(GONE); separator2.setVisibility(GONE);
        }
        else if(ignore2 && ignore3 && ignore4){
            o3.setVisibility(GONE); separator2.setVisibility(GONE);
            o4.setVisibility(GONE); separator3.setVisibility(GONE);
            o2.setVisibility(GONE); separator1.setVisibility(GONE);
        }
    }

    public MultiChoiceLayout setBackground(int color, int width, int choiceOfBackground){
        GradientDrawable drawable = (GradientDrawable) linearLayout.getBackground();
        if(choiceOfBackground == STROKE)  drawable.setStroke(width, color);
        else if (choiceOfBackground == SOLID) drawable.setColor(color);

        separator1.setBackgroundColor(color);
        separator2.setBackgroundColor(color);
        separator3.setBackgroundColor(color);

        return this;
    }

    public MultiChoiceLayout setOptionTextColor(int color){
        o1.setTextColor(color);
        o2.setTextColor(color);
        o3.setTextColor(color);
        o4.setTextColor(color);
        return this;
    }

    public MultiChoiceLayout setOptionText(String optionText1, String optionText2, String optionText3, String optionText4){
        o1.setText(optionText1);
        if (optionText2 != null) { o2.setText(optionText2); o2.setOnClickListener(this); }
        if (optionText3 != null) { o3.setText(optionText3); o3.setOnClickListener(this); }
        if (optionText4 != null) { o4.setText(optionText4); o4.setOnClickListener(this); }
        return this;
    }

    public MultiChoiceLayout setIgnoreChoices(boolean opt2, boolean opt3, boolean opt4){
        ignore2 = opt2;
        ignore3 = opt3;
        ignore4 = opt4;
        Log.e(String.valueOf(ignore2) + String.valueOf(ignore3), String.valueOf(ignore4));
        setViewVisibilities();
        return this;
    }

    private void setViewVisibilities() {
        if (ignore4 && !ignore2 && !ignore3){
            o4.setVisibility(GONE); separator3.setVisibility(GONE);
        }
        else if(ignore3 && ignore4 && !ignore2){
            o4.setVisibility(GONE); separator3.setVisibility(GONE);
            o3.setVisibility(GONE); separator2.setVisibility(GONE);
        }
        else if(ignore2 && ignore3 && ignore4){
            o3.setVisibility(GONE); separator2.setVisibility(GONE);
            o4.setVisibility(GONE); separator3.setVisibility(GONE);
            o2.setVisibility(GONE); separator1.setVisibility(GONE);
        }

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.opt1){
            o1.setBackgroundResource(R.drawable.colorback_textview_background);
            o2.setBackgroundResource(R.drawable.transparent_textview_background);
            o3.setBackgroundResource(R.drawable.transparent_textview_background);
            o4.setBackgroundResource(R.drawable.transparent_textview_background);
            selection = 1;
        }else if(view.getId() == R.id.opt2){
            o2.setBackgroundResource(R.drawable.colorback_textview_background);
            o1.setBackgroundResource(R.drawable.transparent_textview_background);
            o3.setBackgroundResource(R.drawable.transparent_textview_background);
            o4.setBackgroundResource(R.drawable.transparent_textview_background);
            selection = 2;
        }else if(view.getId() == R.id.opt3){
            o3.setBackgroundResource(R.drawable.colorback_textview_background);
            o1.setBackgroundResource(R.drawable.transparent_textview_background);
            o2.setBackgroundResource(R.drawable.transparent_textview_background);
            o4.setBackgroundResource(R.drawable.transparent_textview_background);
            selection = 3;
        }else if(view.getId() == R.id.opt4){
            o4.setBackgroundResource(R.drawable.colorback_textview_background);
            o1.setBackgroundResource(R.drawable.transparent_textview_background);
            o2.setBackgroundResource(R.drawable.transparent_textview_background);
            o3.setBackgroundResource(R.drawable.transparent_textview_background);
            selection = 4;
        }
        multiChoiceOnclick.onMultiChoiceLayoutClick();
    }

    public interface MultiChoiceOnclick{
        void onMultiChoiceLayoutClick();
    }

    public void setOnClickListener(MultiChoiceOnclick multiChoiceOnclick){
        this.multiChoiceOnclick = multiChoiceOnclick;
    }

    public static int getSelection(){
        return selection;
    }
}