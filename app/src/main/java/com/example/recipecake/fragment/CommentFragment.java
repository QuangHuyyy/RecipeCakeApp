package com.example.recipecake.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.R;
import com.example.recipecake.adapter.CakeRowAdapter;
import com.example.recipecake.adapter.CommentAdapter;
import com.example.recipecake.models.Cake;
import com.example.recipecake.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentFragment extends Fragment {
    private View mView;

    private RecyclerView rcvComment;
    private CommentAdapter adapter;

    private Button btnSend;
    private EditText edtComment;

    private List<Comment> listComment;
    
    public CommentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_comment, container, false);

        rcvComment = mView.findViewById(R.id.rcv_comment);
        btnSend = mView.findViewById(R.id.btnSend);
        edtComment = mView.findViewById(R.id.edt_comment);

        initComment();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edtComment.getText().toString().trim())){
                    Toast.makeText(getContext(), "Vui lòng nhập nội dung!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        return mView;
    }

    private void initComment() {
        adapter = new CommentAdapter(getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rcvComment.setLayoutManager(gridLayoutManager);

        listComment = new ArrayList<>();
        listComment.add(new Comment());
        listComment.add(new Comment());
        listComment.add(new Comment());
        adapter.setData(listComment);

        rcvComment.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (adapter != null)
            adapter.release();
    }
}
