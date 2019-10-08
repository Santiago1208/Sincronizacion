package appmoviles.com.preclase11;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import appmoviles.com.preclase11.model.entity.Photo;


public class PhotoAdapter extends BaseAdapter {

    ArrayList<Photo> photos;

    public PhotoAdapter(){
        photos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Object getItem(int i) {
        return photos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //6...
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.photo_row, null);
        ImageView rowImage = rowView.findViewById(R.id.row_image);
        TextView rowName = rowView.findViewById(R.id.row_name);
        TextView rowViews = rowView.findViewById(R.id.row_views);
        TextView rowDesc = rowView.findViewById(R.id.row_description);

        rowName.setText(photos.get(i).getName());
        rowViews.setText("Views: "+photos.get(i).getViews());
        rowDesc.setText(photos.get(i).getDescription());

        File file = new File(viewGroup.getContext().getExternalFilesDir(null) + "/" + photos.get(i).getId() + ".png");
        Bitmap imagen = BitmapFactory.decodeFile(file.toString());
        rowImage.setImageBitmap(imagen);
        return rowView;
        //6...
    }

    public void addPhoto(Photo photo){
        photos.add(photo);
        notifyDataSetChanged();
    }

    public void clear() {
        photos.clear();
    }
}
