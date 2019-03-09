package com.example.fossilsandskeletons;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Dinosaurs = {
            R.drawable.t_rex,
            R.drawable.stegosaurus,
            R.drawable.triceratops,
            };
    Integer[] Skeletons = {
            R.drawable.t_rex_skeleton,
            R.drawable.stegosaurus_skeleton,
            R.drawable.triceratops_skeleton
    };

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Selected Species " + (position + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Skeletons[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter{
        private Context context;

        public ImageAdapter(Context c) {
            context=c;

        }

        @Override
        public int getCount() { return Dinosaurs.length; }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Dinosaurs[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,330));
            return pic;
        }
    }
}
