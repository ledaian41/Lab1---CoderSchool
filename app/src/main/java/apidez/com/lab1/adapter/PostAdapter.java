package apidez.com.lab1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import apidez.com.lab1.R;
import apidez.com.lab1.model.Post;

/**
 * Created by nongdenchet on 10/9/16.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    private ViewHolder viewHolder;
    private List<Post> mPosts;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, -1);
        mPosts = posts;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO: Insert your code
//        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_post, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

            //fill data
//            bindViewHolder(position,viewHolder);

        } else {
            convertView.getTag();
        }
        bindViewHolder(position, viewHolder);
        return convertView;
    }

    private void bindViewHolder(int position, ViewHolder viewHolder) {
        Post post = mPosts.get(position);
        // TODO: Insert your code
        viewHolder.tvUsername.setText(post.getUsername());
        viewHolder.tvDescription.setText(post.getDescription());
        viewHolder.tvDate.setText(post.getDate());
        loadImage(viewHolder.ivAvatar, post.getAvatar());
        loadImage(viewHolder.ivImage, post.getImage());

    }

    private void loadImage(ImageView imageView, String path) {
        // TODO: Insert your code
        Picasso.with(getContext())
                .load(path)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }

    public class ViewHolder {

        public final TextView tvUsername;
        public final TextView tvDescription;
        public final TextView tvDate;
        public final ImageView ivAvatar;
        public final ImageView ivImage;

        ViewHolder(View convertView) {
            tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
            tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        }
    }
}
