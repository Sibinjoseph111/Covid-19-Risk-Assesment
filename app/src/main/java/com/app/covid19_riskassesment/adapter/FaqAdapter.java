package com.app.covid19_riskassesment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.app.covid19_riskassesment.R;
import com.app.covid19_riskassesment.model.FaqModel;

import java.util.ArrayList;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

    private ArrayList<FaqModel> faqs;
    private Context mContext;
    private LinearLayout rootView;

    public FaqAdapter(Context mContext, ArrayList<FaqModel> faqs, LinearLayout rootView) {
        this.faqs = faqs;
        this.mContext = mContext;
        this.rootView = rootView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.faq_question_layout,parent,false);
        return new FaqAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final int[] rotationAngle = {0};

        holder.question_TV.setText(faqs.get(position).getQuestion());
        holder.answer_TV.setText(faqs.get(position).getAnswer());
        holder.questionNo_TV.setText(String.valueOf(position+1)+".");

        holder.question_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotationAngle[0] = rotationAngle[0] == 0 ? 180 : 0;  //toggle
                TransitionManager.beginDelayedTransition(rootView,new AutoTransition());
                if (holder.answer_TV.getVisibility() == View.VISIBLE){
                    holder.answer_TV.setVisibility(View.GONE);
                }else holder.answer_TV.setVisibility(View.VISIBLE);

                holder.arrow_IV.animate().rotation(rotationAngle[0]).setDuration(300).start();
            }
        });

    }

    @Override
    public int getItemCount() {
        return faqs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView question_TV, answer_TV, questionNo_TV;
        CardView question_CV;
        ImageView arrow_IV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            question_TV = mView.findViewById(R.id.faqQuestion_TV);
            answer_TV = mView.findViewById(R.id.faqAnswer_TV);
            question_CV = mView.findViewById(R.id.faqQuestion_CV);
            arrow_IV = mView.findViewById(R.id.faqExpandArrow_IV);
            questionNo_TV = mView.findViewById(R.id.faqQuestionNo_TV);
        }
    }
}
