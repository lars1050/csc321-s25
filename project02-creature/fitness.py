import math

# Thank you claude.ai for you guidance and code
# And thanks Dr. Dasgupta in physics

# rotation around y and z at the first pair of angles
angleY1 = 0
angleZ1 = -90

# rotation around y and z at the second pair of angles
angleY2 = 0
angleZ2 = 0


arm_length = 5

def calc_position(ay,az):
    # convert degrees to radians
    ay = ay*math.pi/180
    az = az*math.pi/180

    # using forward kinematics to calculate the position of
    # the end of the arm in 3 dimensional space
    x = arm_length * math.cos(az) * math.cos(ay)
    y = arm_length * math.sin(az) * math.cos(ay)
    z = arm_length * math.sin(ay)
    
    return [x, y, z]

def calculate_distance(prev_position, curr_position, time):
    # how much the arm changed position along the y-axis
    delta_y = curr_position[1] - prev_position[1]
    # the rate of change
    velocity = delta_y / time

    # scale the distance by velociy. The faster the mostion, the further it travelled.
    return delta_y * velocity*velocity

# determine the position of the end of the arm for each angle pair     
pos1 = calc_position(angleY1,angleZ1)
pos2 = calc_position(angleY2,angleZ2)

print(pos1,pos2)

# using a default time unit of 10 between each set of angles
distance = calculate_distance(pos1,pos2,2)
print(distance)
