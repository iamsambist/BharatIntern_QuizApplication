package com.sunna.quizapp.quiz;
public class QuizPresenter implements QuizContract.Presenter{
    QuizContract.View view;
    Model model;

    public QuizPresenter(QuizContract.View view,int selectedQuiz){
        this.view = view;
        model = ModelFactory.getProduct(selectedQuiz);
    }

    @Override
    public void getQuestion(int index) {
       view.setQuestion(model.getQuestion(index));
    }

    @Override
    public void getOptions(int index) {
        view.setOptions(model.getOptions(index));

    }

    @Override
    public boolean checkCorrectOption(int index,String ansClicked) {
        String correctAns = model.getCorrectOption(index);
        if(correctAns.equals(ansClicked)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean validatLength(int currentIndex) {
       return model.validateLength(currentIndex);
    }

    @Override
    public void updateScore(int item) {
        item = item + 1;
        view.setScoreText(item);
    }
}
