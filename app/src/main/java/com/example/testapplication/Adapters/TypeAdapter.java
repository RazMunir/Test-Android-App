package com.example.testapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;
import com.example.testapplication.SubType;
import com.example.testapplication.Type;

import java.util.ArrayList;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolderClass> {
    ArrayList<Type> typeArrayList;
    Context context;

    public TypeAdapter() {
    }

    public TypeAdapter(ArrayList<Type> typeArrayList, Context context) {
        this.typeArrayList = typeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TypeAdapter.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_type, parent, false);
        return new TypeAdapter.ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeAdapter.ViewHolderClass holder, int position) {
        Type type = typeArrayList.get(position);
        holder.typeTitleTextView.setText(type.getName());
//        holder.typeSubTypeContainerLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Clicked item "+position+1, Toast.LENGTH_SHORT).show();
//            }
//        });

        boolean isExpanded = typeArrayList.get(position).isExpanded();
        holder.typeSubTypeContainerLinearLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        ArrayList<SubType> subTypeArrayList = new ArrayList<>();
        subTypeArrayList.add(new SubType("HP"));
        subTypeArrayList.add(new SubType("Dell"));
        subTypeArrayList.add(new SubType("Apple"));
        subTypeArrayList.add(new SubType("Toshiba"));
        holder.subTypeAdapter.replaceArrayList(subTypeArrayList);
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
        return typeArrayList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView typeTitleTextView;
        LinearLayout typeSubTypeContainerLinearLayout;
        RecyclerView subTypeRecyclerView;

        ArrayList<SubType> subTypeArrayList;
        SubTypeAdapter subTypeAdapter;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            typeTitleTextView = itemView.findViewById(R.id.tv_typeTitle);
            typeSubTypeContainerLinearLayout = itemView.findViewById(R.id.ll_type_subtype_container);
            subTypeRecyclerView = itemView.findViewById(R.id.rv_sub_type);

            subTypeArrayList = new ArrayList<>();
            subTypeArrayList.add(new SubType("HP"));
            subTypeArrayList.add(new SubType("Dell"));
            subTypeArrayList.add(new SubType("Apple"));

            subTypeAdapter = new SubTypeAdapter();
            subTypeRecyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(),3));
            subTypeAdapter = new SubTypeAdapter(subTypeArrayList, itemView.getContext());
            subTypeRecyclerView.setAdapter(subTypeAdapter);

            typeTitleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Type type = typeArrayList.get(getAdapterPosition());
                    type.setExpanded(!type.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

    public void replaceArrayList(ArrayList<Type> typeArrayList) {
        this.typeArrayList = typeArrayList;
        notifyDataSetChanged();
    }
}
