package com.atariage.atarimanuals;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tschak on 7/31/2016.
 */
public class GameListViewAdapter extends BaseAdapter {

    private String[] _title_graphic_paths;
    private Activity activity;
    private LayoutInflater inflater;

    public GameListViewAdapter(Activity activity, String[] _title_graphic_paths) {
        this.activity = activity;
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

    private class GameListViewHolder {
        GameItemTextView iv;

        public GameListViewHolder(View view) {
            iv = (GameItemTextView) view.findViewById(R.id.game_list_item_text_view);
        }
    }

}
