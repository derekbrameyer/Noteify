package com.doomonafireball.noteify.fragment;

import com.doomonafireball.noteify.R;
import com.doomonafireball.noteify.model.Note;
import com.doomonafireball.noteify.util.ImageUtils;
import com.doomonafireball.noteify.util.NotificationUtils;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import roboguice.inject.InjectView;

/**
 * User: derek Date: 7/15/12 Time: 8:35 AM
 */
public class CreateNoteFragment extends RoboSherlockFragment {

    @InjectView(R.id.ET_note_title) private EditText noteTitleET;
    @InjectView(R.id.ET_note_text) private EditText noteTextET;
    @InjectView(R.id.CB_note_sticky) private CheckBox noteStickCB;
    @InjectView(R.id.CB_note_reminder) private CheckBox noteReminderCB;
    @InjectView(R.id.BTN_note_icon) private Button noteIconBTN;
    @InjectView(R.id.BTN_create_note) private Button createNoteBTN;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_note_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();
        createNoteBTN.setOnClickListener(createNoteOCL);
    }

    private View.OnClickListener createNoteOCL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Note n = new Note();
            n.setTitle("test!");
            n.setText("even longer test!");
            n.setIcon(ImageUtils.drawableToBitmap(getResources().getDrawable(R.drawable.icon)));
            n.setSticky(noteStickCB.isChecked());
            NotificationUtils.createNotification(mContext, n);
        }
    };
}
