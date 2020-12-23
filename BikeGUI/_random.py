# INSERT INTO `rent_bike`.`bike` (`id`, `type`, `pin`, `value`, `dockId`, `barcode`) VALUES ('0', '0', '0', '0', '0', '0');
import random
import string

class Bike:
    def __init__(self, id, type, barcode):
        self.id = id
        self.type = type
        self.pin = random.randint(50, 100)
        if type == 0:
            self.value = 400000
        elif type == 1:
            self.value = 550000
        else:
            self.value = 700000
        self.dockId = random.randint(0, 11)
        self.barcode = barcode

def toString(bike):
    return "INSERT INTO `rent_bike`.`bike` (`id`, `type`, `pin`, `value`, `dockId`, `barcode`) VALUES ('" + str(bike.id) + "', '" + str(bike.type) + "', '" + str(bike.pin) + "', '" + str(bike.value) + "', '" + str(bike.dockId) + "', '" + str(bike.barcode) + "');"
s = set()
for i in range(360):
    barcode = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(5))
    while barcode in s:
        barcode = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(5))
    s.add(barcode)
    type = random.randint(0, 2)
    bike = Bike(i, type, barcode)
    print(toString(bike))

print(len(s))