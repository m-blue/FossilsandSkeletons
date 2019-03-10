package com.example.fossilsandskeletons;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Dinosaurs = {
            R.drawable.t_rex,
            R.drawable.stegosaurus,
            R.drawable.triceratops,
            R.drawable.velociraptor,
            R.drawable.diplodocus
            };
    Integer[] Skeletons = {
            R.drawable.t_rex_skeleton,
            R.drawable.stegosaurus_skeleton,
            R.drawable.triceratops_skeleton,
            R.drawable.velociraptor_skeleton,
            R.drawable.diplodocus_skeleton
    };
    enum Dino {
            TREX,
        STEG,
        TRI,
        VEL,
        DIPLO
    }
    String[] Names = {
            "T-rex",
            "Stegosaurus",
            "Triceratops",
            "Velociraptor",
            "Diplodocus"
    };

    ImageView pic;
    Button btnLearn;
    Dino dino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLearn = findViewById(R.id.btnLearn);

        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),Names[position], Toast.LENGTH_SHORT).show();
                pic.setImageResource(Skeletons[position]);
                dino = Dino.values()[position];
            }
        });
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (dino){
                    case TREX:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nhm.ac.uk/discover/dino-directory/tyrannosaurus.html")));
                        break;
                    case STEG:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nhm.ac.uk/discover/dino-directory/stegosaurus.html")));
                        break;
                    case TRI:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nhm.ac.uk/discover/dino-directory/triceratops.html")));
                        break;
                    case VEL:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nhm.ac.uk/discover/dino-directory/velociraptors.html")));
                        break;
                    case DIPLO:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nhm.ac.uk/discover/dino-directory/diplodocus.html")));
                        break;
                    default:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nhm.ac.uk/discover/dinosaurs.html")));
                        break;
                }
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
