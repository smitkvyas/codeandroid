package in.co.codeandroid.mobilelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get recyclerview from UI
        RecyclerView recyclerMobileList = findViewById(R.id.recylerMobileList);

        // create sample data for list
        final ArrayList<MobilePhone> mobilePhones = new ArrayList<>();
        mobilePhones.add(new MobilePhone().setPrice(70000).setModelName("Samsung Galaxy - S9").setModelYear(2018).setDetailsLink("google.com"));
        mobilePhones.add(new MobilePhone().setPrice(70000).setModelName("Samsung Galaxy - S10").setModelYear(2019).setDetailsLink("google.com"));
        mobilePhones.add(new MobilePhone().setPrice(70000).setModelName("Samsung Galaxy - S11").setModelYear(2020).setDetailsLink("google.com"));

        // create object for adapter class
        final MobileListAdapter mobileListAdapter = new MobileListAdapter(mobilePhones);
        int orientation = RecyclerView.HORIZONTAL;
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerMobileList);
        recyclerMobileList.setLayoutManager(new LinearLayoutManager(this, orientation, false));

        // attach adapter to recyclerview and render
        recyclerMobileList.setAdapter(mobileListAdapter);
        mobileListAdapter.notifyDataSetChanged();


        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobilePhones.add(new MobilePhone().setPrice(70000).setModelName("Samsung Galaxy - S12").setModelYear(2021).setDetailsLink("google.com"));
                if (mobileListAdapter != null) {
                    mobileListAdapter.notifyItemInserted(mobilePhones.size());
                }
            }
        });
    }


    class MobileListAdapter extends RecyclerView.Adapter<MobileListAdapter.MobileViewHolder> {

        List<MobilePhone> mobilePhoneList;
        private int lastPosition = -1;

        public MobileListAdapter(List<MobilePhone> mobilePhoneList) {
            this.mobilePhoneList = mobilePhoneList;
        }

        @NonNull
        @Override
        public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MobileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_mobile, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MobileViewHolder holder, int position) {
            final MobilePhone mobilePhone = mobilePhoneList.get(holder.getAdapterPosition());
            holder.txtModelName.setText(mobilePhone.getModelName());
            holder.txtModelPrice.setText(String.format("₹ %s/-", mobilePhone.getPrice()));
            holder.txtModelYear.setText(String.format("Year - %s", mobilePhone.getModelYear()));

            holder.txtDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(mobilePhone.getDetailsLink()));
                    startActivity(browserIntent);
                }
            });

            setAnimation(holder.itemView, position);
        }

        private void setAnimation(View viewToAnimate, int position) {
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }

        @Override
        public int getItemCount() {
            return mobilePhoneList.size();
        }

        public class MobileViewHolder extends RecyclerView.ViewHolder {
            private final TextView txtModelName, txtModelPrice, txtModelYear, txtDetail;

            public MobileViewHolder(@NonNull View itemView) {
                super(itemView);
                txtModelName = itemView.findViewById(R.id.txtModelName);
                txtModelPrice = itemView.findViewById(R.id.txtModelPrice);
                txtModelYear = itemView.findViewById(R.id.txtModelYear);
                txtDetail = itemView.findViewById(R.id.txtDetail);
            }
        }
    }
}
