package com.xeroy.profileapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xeroy.profileapplication.R;

import java.util.ArrayList;

/**
 * Created by Khalid on 2018-03-25.
 */

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context c;
    private ArrayList<Job> job;
    private LayoutInflater inflater;

    public CustomAdapter(Context c,ArrayList<Job> job)
    {
        this.c=c;
        this.job=job;
        inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // get single job description
    @Override
    public Object getChild(int groupPos, int childPos) {
        // TODO Auto-generated method stub
        return job.get(groupPos).description.get(childPos);
    }

    // get job description ID
    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    // get description row
    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView,
                             ViewGroup parent) {

        //ONLY INFLATER XML ROW LAYOUT IF ITS NOT PRESENT,OTHERWISE REUSE IT

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.job_description, null);
        }

        //GET CHILD NAME
        String child = (String) getChild(groupPos, childPos);

        //SET CHILD NAME
        TextView nameTv = (TextView) convertView.findViewById(R.id.textView1);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView1);

        nameTv.setText(child);

        return convertView;
    }

    // get number of job description points
    @Override
    public int getChildrenCount(int groupPosw) {
        // TODO Auto-generated method stub
        return job.get(groupPosw).description.size();
    }

    // get job
    @Override
    public Object getGroup(int groupPos) {
        // TODO Auto-generated method stub
        return job.get(groupPos);
    }

    // get number of jobs
    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return job.size();
    }

    // get job ID
    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    // get job row
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        // ONLY INFLATE XML JOB ROW MODEL IF ITS NOT PRESENT,OTHERWISE REUSE IT
        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.jobs, null);
        }

        // get group/job item
        Job t=(Job) getGroup(groupPosition);

        // set group name
        TextView nameTv=(TextView) convertView.findViewById(R.id.textView1);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);

        String name=t.Name;
        nameTv.setText(name);

        // assign job images according to job names

        if(name=="Rogers")
        {
            img.setImageResource(R.drawable.rogers);
            img.getBackground().setAlpha(0);
            nameTv.setText("IT New Grad");
        }else if(name=="N8 Identity")
        {
            img.setImageResource(R.drawable.n8identity);
            img.getBackground().setAlpha(0);
            nameTv.setText("Solutions Engineer");
        }else if(name=="Ford")
        {
            img.setImageResource(R.drawable.ford);
            img.getBackground().setAlpha(0);
            nameTv.setText("QA Analyst Intern");
        }

        // set job row background colour
        //convertView.setBackgroundColor(Color.LTGRAY);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }
}
