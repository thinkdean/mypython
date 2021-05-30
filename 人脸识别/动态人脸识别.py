# 导入库
import cv2
# 打开摄像头
capture = cv2.VideoCapture(0)
# 导入模型
face_model = cv2.CascadeClassifier('./facemodel.xml')

# 获取摄像头的实时画面
while True:
    # 读取当前摄像头一帧的画面true,false
    ret,image = capture.read()
    # 图片灰度处理
    gray = cv2.cvtColor(image,cv2.COLOR_RGB2GRAY)
    # 人脸检测
    faces = face_model.detectMultiScale(gray)   #容易卡，要优化
    #faces = face_model.detectMultiScale(gray,1.1,3,0,(100,100))  #优化后不卡了，但太小就识别不了
    # 标记人脸
    for (x,y,w,h) in faces:
        cv2.rectangle(image,(x,y),(x+w,y+h),(0,255,0),2)
    # 显示图片
        cv2.imshow('qiao zhi...',image)
    # 暂停窗口
        if cv2.waitKey(5) & 0xFF == ord('q'):
            break
# 释放资源
capture.release()
# 销毁窗口
cv2.destroyAllWindows()
