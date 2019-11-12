package com.example.cpsc411assignment2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cpsc411assignment2.DetailScreen;
import com.example.cpsc411assignment2.Model.Student;
import com.example.cpsc411assignment2.Model.StudentDB;
import com.example.cpsc411assignment2.R;

public class SummaryListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return StudentDB.getInstance().getStudentList().size();
        }

        @Override
        public Object getItem(int i) {
            return StudentDB.getInstance().getStudentList().get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View row_view;

            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                row_view = inflater.inflate(R.layout.person_row, viewGroup, false);
            } else row_view = view;

            //
            Student p = StudentDB.getInstance().getStudentList().get(i);
            //
            ((TextView) row_view.findViewById(R.id.first_name)).setText(p.getFirstName());
            ((TextView) row_view.findViewById(R.id.last_name)).setText(p.getLastName());
            //((TextView) row_view.findViewById(R.id.cwid)).setText(p.getCWID());
            row_view.setTag(new Integer(i));

            row_view.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Page Navigation
                            Intent intent = new Intent(view.getContext(), DetailScreen.class);
                            intent.putExtra("PersonIndex", ((Integer)view.getTag()).intValue());
                            view.getContext().startActivity(intent);
                        }
                    }
            );



            return row_view;
        }
}
