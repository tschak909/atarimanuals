package com.atariage.atarimanuals;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tschak on 7/31/2016.
 */
public class GameListViewAdapter extends BaseAdapter implements Filterable {

    private String[] _full_title_graphic_paths;
    private String[] _title_graphic_paths;
    private Activity activity;
    private LayoutInflater inflater;

    public GameListViewAdapter(Activity activity, String[] _title_graphic_paths) {
        this.activity = activity;
        this._full_title_graphic_paths = _title_graphic_paths;
        this._title_graphic_paths = _title_graphic_paths;
        this.inflater = LayoutInflater.from(this.activity);

    }

    @Override
    public int getCount() {
        return _title_graphic_paths.length;
    }

    @Override
    public String getItem(int i) {
        return _title_graphic_paths[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        GameListViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.game_title_item, viewGroup, false);
            mViewHolder = new GameListViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (GameListViewHolder) convertView.getTag();
        }

        String titleTextPath = "title_".concat(getItem(i));
        Log.e("GETMANUAL",titleTextPath);
        int titleTextResource = activity.getResources().getIdentifier(titleTextPath,"string","com.atariage.atarimanuals");
        String titleText = activity.getResources().getString(titleTextResource);

        mViewHolder.iv.setText(titleText);

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                _title_graphic_paths = (String[]) results.values;
                GameListViewAdapter.this.notifyDataSetChanged();
            }

            @NonNull
            private String[] getFilteredResults(CharSequence constraint)
            {
                String constraint0 = constraint.toString();
                constraint0 = constraint0.toLowerCase();
                ArrayList<String> tempResults = new ArrayList<String>(Arrays.asList(_full_title_graphic_paths));
                ArrayList<String> returnedResults = new ArrayList<String>();

                for (String s:tempResults)
                {
                    if (s.contains(constraint0))
                    {
                        returnedResults.add(s);
                    }
                }

                return returnedResults.toArray(new String[0]);

            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String[] filteredResults = getFilteredResults(constraint);

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }

    private class GameListViewHolder {
        GameItemTextView iv;

        public GameListViewHolder(View view) {
            iv = (GameItemTextView) view.findViewById(R.id.game_list_item_text_view);
        }
    }

}
