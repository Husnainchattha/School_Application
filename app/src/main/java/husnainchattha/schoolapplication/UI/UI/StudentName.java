package husnainchattha.schoolapplication.UI.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import DataBase.DataBaseHandler;
import DataBase.DataModel;
import husnainchattha.schoolapplication.R;

public class StudentName extends AppCompatActivity {
 private RecyclerView recyclerView;
 private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_name);
        this.context=this;
        DataBaseHandler helper=new DataBaseHandler(this);
        ArrayList<DataModel> ayats=helper.getAllStudent();
        recyclerView=findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(StudentName.this));
        OurAdapter adapter=new OurAdapter(ayats);
        recyclerView.setAdapter(adapter);
    }
    public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
        private final ArrayList<DataModel> data;
        public OurAdapter(ArrayList<DataModel> data) {
            this.data=data;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false));
        }
        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {
            DataModel ayat=data.get(position);
            holder.textView.setText(ayat.getName());
            holder.textView1.setText(ayat.getRollno());
        }
        @Override
        public int getItemCount() {
            return data.size();
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            TextView textView1;

            public ViewHolder(View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.shownm);
                textView1=itemView.findViewById(R.id.showrn);
            }
        }
    }
    /*
    public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
        private final ArrayList<DataModel>data;
        public OurAdapter(ArrayList<DataModel>data){
           this.data=data;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          DataModel info=data.get(position);
          holder.textname.setText(info.getName());
          holder.textrollno.setText(info.getFathername());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView textname;
            public TextView textrollno;
            public ViewHolder(View itemView) {
                super(itemView);
                textname=itemView.findViewById(R.id.shownm);
                textrollno=itemView.findViewById(R.id.showrn);
            }
        }
    }*/

}
