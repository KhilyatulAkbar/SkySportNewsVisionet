package id.sch.smktelkom_mlg.learn.skysportnewsvisionet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.R;
import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.model.Articles;

/**
 * Created by Mang Arblu on 12/6/2016.
 */

public class ArticleAdapter extends ArrayAdapter<Articles> {

    List<Articles> articlesList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public ArticleAdapter(Context context, List<Articles> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        articlesList = objects;
    }

    @Override
    public Articles getItem(int position) {
        return articlesList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Articles item = getItem(position);

        vh.tvTitle.setText(item.getTitle());
        vh.tvDescription.setText(item.getDescription());
        Picasso.with(context).load(item.getUrlToImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView tvTitle;
        public final TextView tvDescription;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView tvTitle, TextView tvDescription) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.tvTitle = tvTitle;
            this.tvDescription = tvDescription;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewTitle);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewDescription);
            return new ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }
}
