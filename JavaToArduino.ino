#define LED 3

void setup()
{                
    Serial.begin(9600);
    pinMode(LED, OUTPUT);
}

void loop()
{
    String text = Serial.readString();
     
    if (text.length() > 0) {
      Serial.println(text);

      if (text.startsWith("!on")){
        digitalWrite(LED, HIGH);
      } else if (text.startsWith("!off")) {
        digitalWrite(LED, LOW);
      }
    }
     
}
