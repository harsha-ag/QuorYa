package com.example.qnew.search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.qnew.R;
import com.example.qnew.ViewProfileActivity;
import com.example.qnew.singlequestion.ShowSingleQuestionActivity;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.searchviewholder>{

    private List<SearchData> list;

    public SearchAdapter(List<SearchData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public searchviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from( parent.getContext() ).inflate( R.layout.search_listitems,parent,false );
        return new searchviewholder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull searchviewholder holder, int position) {
       SearchData searchData =list.get( position );





        holder.personname.setText( searchData.getProfileName() );

        Glide.with(holder.personimage.getContext())
                .load(searchData.getProfilePicture())
                .placeholder(R.drawable.ic_menu_camera)
                .into(holder.personimage);
        holder.personname.setOnClickListener( v -> goToSinglePost(v) );
        holder.personimage.setOnClickListener( v -> goToSinglePost(v) );

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    private void goToSinglePost(View v) {
        //intent

        Intent intent = new Intent(v.getContext(), ViewProfileActivity.class);
        v.getContext().startActivity(intent);

    }


    public static class searchviewholder extends RecyclerView.ViewHolder
    {
        public TextView personname;
        public ImageView personimage;
        public searchviewholder(@NonNull View itemView) {
            super( itemView );
            personname= itemView.findViewById( R.id.tv_lb_username );
            personimage= itemView.findViewById( R.id.cv_searchlistitems_image);
        }
    }
}
