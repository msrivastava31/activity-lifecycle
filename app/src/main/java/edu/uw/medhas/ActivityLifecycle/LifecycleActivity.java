package edu.uw.medhas.ActivityLifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LifecycleActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditText;
    private final String TEXT_VIEW_CONTENT = "text_view_content";
    private final String EDIT_TEXT_CONTENT = "edit_text_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        mTextView = (TextView) findViewById(R.id.text_box);
        mEditText = (EditText) findViewById(R.id.text_edit);

        restoreText(savedInstanceState);
    }

    private void restoreText(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getCharSequence(TEXT_VIEW_CONTENT));
            mEditText.setText(savedInstanceState.getString(EDIT_TEXT_CONTENT));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putCharSequence(TEXT_VIEW_CONTENT, mTextView.getText());
        outState.putString(EDIT_TEXT_CONTENT, String.valueOf(mEditText.getText()));

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreText(savedInstanceState);
    }

    public void submitText(View view) {
        mTextView.setText(mEditText.getText());
    }
}
