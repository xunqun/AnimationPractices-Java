package com.whilerain.animationpractices.lesson5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whilerain.animationpractices.R;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.YouTubeDemoViewHolder> {

    @NonNull
    @Override
    public YouTubeDemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(viewType, parent, false);
        switch (viewType) {

            case R.layout.motion_24_recyclerview_expanded_text_header:
                return new TextHeaderViewHolder(itemView);

            case R.layout.motion_24_recyclerview_expanded_text_description:
                return new TextDescriptionViewHolder(itemView);

            case R.layout.motion_24_recyclerview_expanded_row:
                return new CatRowViewHolder(itemView);

            default:
                throw new IllegalStateException("Unknown viewType $viewType");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull YouTubeDemoViewHolder holder, int position) {
        if (holder instanceof TextHeaderViewHolder) {

        } else if (holder instanceof TextDescriptionViewHolder) {

        } else {
            int imagePosition = position - 2;
            ((CatRowViewHolder)holder).textView.setText("CAT");
            ((CatRowViewHolder)holder).imageView.setImageResource(Cats.catImages[imagePosition]);
        }
    }

    @Override
    public int getItemCount() {
        return Cats.catImages.length + 2;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0 : return R.layout.motion_24_recyclerview_expanded_text_header;
            case 1 : return R.layout.motion_24_recyclerview_expanded_text_description;
            default : return R.layout.motion_24_recyclerview_expanded_row;
        }
    }

    class YouTubeDemoViewHolder extends RecyclerView.ViewHolder{

        public YouTubeDemoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class TextHeaderViewHolder extends YouTubeDemoViewHolder{

        public TextHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class TextDescriptionViewHolder extends YouTubeDemoViewHolder{

        public TextDescriptionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class CatRowViewHolder extends YouTubeDemoViewHolder{
        public ImageView imageView;
        public TextView textView;
        public CatRowViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_row);
            textView = itemView.findViewById(R.id.text_row);
        }
    }
}
