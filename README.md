# Đã sửa sau khi báo cáo
# Phần mềm thuê xe Bike Rental - Thiết kế và cài đặt bởi nhóm 10

Các thành viên trong nhóm

1. Đặng Lâm San
2. Nguyễn Mai Phương
3. Dương Hồng Sơn

## Mô tả chi tiết và demo sản phẩm

[Video Demo sản phẩm](https://youtu.be/gRvQ3Y3Erc8) 

## Các file báo cáo Slide, SRS, SDD

Được đặt tại thư mục `Document`

## File Astah

Được đặt tại thư mục `Astah`

## Source code của phần mềm Bike Rental

Được đặt tại `BikeGUI`

## Javadoc

Được đặt tại `BikeGUI/javadoc`

## Hướng dẫn cài đặt sản phẩm Bike Rental

### Requirements

1. Google Json - `gson-2.3.1.jar`
2. MySQL Connector J - `mysql-connector-java-8.0.22.jar`
3. JavaFX SDK
4. Máy tính yêu cầu kết nối mạng để thực hiện các truy vấn giao dịch online

### Installation guide

1. Tải và cài đặt MySQL databases
2. Cài đặt rent_bike database sử dụng `BikeGUI/rent_bike.sql`
3. Build Project bằng Eclipse/IntelliJ sau khi đã thêm các requirements.

Nếu không muốn build lại project, người dùng có thể chạy ứng dụng đã được build sẵn bằng file `jar` bằng câu lệnh sau:

`java -jar --module-path "path-to-lib\javafx-sdk-window-11.0.2\lib" --add-modules=javafx.controls,javafx.graphics,javafx.fxml,javafx.base  BikeGUI/out/artifacts/BikeGUI_jar/BikeGUI.jar`

(Sửa `path-to-lib\javafx-sdk-window-11.0.2\lib` trỏ đến thư viện JavaFX máy người dùng)

# Các phần đã sửa sau khi báo cáo
Chúng em đã sửa code, slide và các tài liệu
Chúng em đã sửa và áp dụng strategy pattern vào các module tính toán tiền và thời gian
