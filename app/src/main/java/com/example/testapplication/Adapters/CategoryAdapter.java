package com.example.testapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.Category;
import com.example.testapplication.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolderClass> {
    ArrayList<Category> categoryArrayList;
    Context context;
    RecyclerView categoryAdapterTypeRecyclerView;

    public CategoryAdapter() {
    }

    public CategoryAdapter(ArrayList<Category> categoryArrayList, Context context) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
    }

    public CategoryAdapter(ArrayList<Category> categoryArrayList, Context context, RecyclerView categoryAdapterTypeRecyclerView) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
        this.categoryAdapterTypeRecyclerView = categoryAdapterTypeRecyclerView;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Category category = categoryArrayList.get(position);
        holder.categoryTitleTextView.setText(category.getName());
        holder.categoryContainerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked item "+position, Toast.LENGTH_SHORT).show();
                //add condition here
                if(categoryAdapterTypeRecyclerView.getVisibility()==View.VISIBLE){
                    categoryAdapterTypeRecyclerView.setVisibility(View.GONE);
                }
                else {
                    categoryAdapterTypeRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
//        final User user = userArrayList.get(position);
//        holder.tv_name.setText(user.getName());
//        holder.tv_age.setText("Age : " + user.getAge());
//        holder.tv_location.setText("Location : " + user.getLocation());
//
//        holder.linearLayout_user.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(GlobalUser.isToUser){
////                    if(!GlobalUser.userFrom.getPlayerId().equals("")){
////                        OSPermissionSubscriptionState status = OneSignal.getPermissionSubscriptionState();
////                        String userID = status.getSubscriptionStatus().getUserId();
////                        user.setPlayerId(userID);
////                    }
//                    Intent intent = new Intent(context, ChatActivity.class);
//                    intent.putExtra("userTo", user);
//                    context.startActivity(intent);
//                }else {
//                    Intent intent = new Intent(context, SelectionUserActivity.class);
//                    intent.putExtra("userFrom", user);
//                    context.startActivity(intent);
//                }
//            }
//        });
//
//        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view = LayoutInflater.from(context).inflate(R.layout.dialog_edit, null);
//                final EditText et_name, et_age, et_location;
//                Button btn_update;
//
//                et_name = view.findViewById(R.id.et_name);
//                et_age = view.findViewById(R.id.et_age);
//                et_location = view.findViewById(R.id.et_location);
//                btn_update = view.findViewById(R.id.btn_update);
//
//                et_name.setText(user.getName());
//                et_age.setText(user.getAge());
//                et_location.setText(user.getLocation());
//
//                final Dialog dialog = new AlertDialog.Builder(context)
//                        .setView(view)
//                        .show();
//
//                btn_update.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        final Map<String, Object> map = new HashMap<>();
//                        map.put("name", et_name.getText().toString());
//                        map.put("age", et_age.getText().toString());
//                        map.put("location", et_location.getText().toString());
//
//                        FirebaseHandler.updateAUser(map,user,context,dialog);
//                    }
//                });
//            }
//        });
//
//        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseHandler.deleteAUser(user,context);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        ImageView categoryIconImageView;
        TextView categoryTitleTextView;
        LinearLayout categoryContainerLinearLayout;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            categoryTitleTextView = itemView.findViewById(R.id.tv_category_title);
            categoryIconImageView = itemView.findViewById(R.id.iv_category_icon);
            categoryContainerLinearLayout = itemView.findViewById(R.id.ll_category_container);

        }
    }

    public void replaceArrayList(ArrayList<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
        notifyDataSetChanged();
    }
}
