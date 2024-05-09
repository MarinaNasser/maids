from flask import Flask, request, jsonify
import pandas as pd
import joblib  # To load a pre-trained model

app = Flask(__name__)

# Load your trained Logistic Regression model
model = joblib.load('logistic_model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    df = pd.DataFrame(data, index=[0])
    prediction = model.predict(df)
    return jsonify({'prediction': int(prediction[0])})

if __name__ == '__main__':
    app.run(debug=True, port=5000)
