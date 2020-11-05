package com.example.testapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;
import com.example.testapplication.SubType;

import java.util.ArrayList;

public class SubTypeAdapter extends RecyclerView.Adapter<SubTypeAdapter.ViewHolderClass> {
    ArrayList<SubType> subTypeArrayList;
    Context context;

    public SubTypeAdapter() {
    }

    public SubTypeAdapter(ArrayList<SubType> subTypeArrayList, Context context) {
        this.subTypeArrayList = subTypeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubTypeAdapter.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_sub_type, parent, false);
        return new SubTypeAdapter.ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubTypeAdapter.ViewHolderClass holder, int position) {
        SubType subType = subTypeArrayList.get(position);
        holder.subTypeTitleTextView.setText(subType.getName());
//        holder.typeSubTypeContainerLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Clicked item "+position+1, Toast.LENGTH_SHORT).show();
//            }
//        });

//        boolean isExpanded = typeArrayList.get(position).isExpanded();
//        holder.typeSubTypeContainerLinearLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
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
        return subTypeArrayList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView subTypeTitleTextView;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            subTypeTitleTextView = itemView.findViewById(R.id.tv_subType_title);
        }
    }

    public void replaceArrayList(ArrayList<SubType> subTypeArrayList) {
        this.subTypeArrayList = subTypeArrayList;
        notifyDataSetChanged();
    }
}

