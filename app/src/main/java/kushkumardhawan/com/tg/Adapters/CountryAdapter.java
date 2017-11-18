package kushkumardhawan.com.tg.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kushkumardhawan.com.tg.LazyLoader.ImageLoader;
import kushkumardhawan.com.tg.Model.Countries;
import kushkumardhawan.com.tg.R;

/**
 * Created by KU854963 on 11/18/2017.
 */

public class CountryAdapter extends ArrayAdapter<Countries> implements Filterable {

    private Context context;
    private List<Countries> countryList;

    private Filter planetFilter;
    private List<Countries> origUserList;

    ImageLoader il = new ImageLoader(context);

    public CountryAdapter(Context context, int resource, List<Countries> objects) {
        super(context, resource, objects);
        this.context = context;
        this.countryList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_country, parent, false);
        Countries countries = countryList.get(position);
        TextView tv1 = (TextView)view.findViewById(R.id.textView1_aadhaar);
        TextView tv2 = (TextView)view.findViewById(R.id.textView2_name);
        ImageView imageView2 = (ImageView)view.findViewById(R.id.imageView1);
        tv1.setText(countries.getName());
        tv2.setText(countries.getCapital());

        if(!countries.getFlag().isEmpty()){
            il.DisplayCircleImage(countries.getFlag(), imageView2, null,null, false);
        }
        else{
            Bitmap defaultPic = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
            imageView2.setImageBitmap(defaultPic);
        }
        return view;
    }

    public Countries getItem(int position) {
        return countryList.get(position);
    }

    public long getItemId(int position) {
        return countryList.get(position).hashCode();
    }


    @Override
    public int getCount() {
        return countryList.size();
    }

    public void resetData() {
        countryList = origUserList;
    }

    /*
	 * We create our filter
	 */

    @Override
    public Filter getFilter() {
        if (planetFilter == null)
            planetFilter = new PlanetFilter();

        return planetFilter;
    }

    private class PlanetFilter  extends Filter {



        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = origUserList;
                results.count = origUserList.size();
            }
            else {
                // We perform filtering operation
                List<Countries> nPlanetList = new ArrayList<>();

                for (Countries p : countryList) {
                    if (p.getName().toUpperCase().contains(constraint.toString().toUpperCase()))
                        nPlanetList.add(p);
                    if (p.getCapital().toUpperCase().contains(constraint.toString().toUpperCase()))
                        nPlanetList.add(p);
                }

                results.values = nPlanetList;
                results.count = nPlanetList.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                countryList = (List<Countries>) results.values;
                notifyDataSetChanged();
            }

        }

    }

}