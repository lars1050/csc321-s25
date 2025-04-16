import numpy as np
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation
from mpl_toolkits.mplot3d import Axes3D

import random
import math

# Thank you claude.ai for you guidance and code

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


def animate(angles,time_step=20):
    '''
    Create an animation based on the gait angles.
    The list of angles are comprised of pairs of rotation (around y and z).
    A trajectory is constructed from point to point, each with time_step angles in betwee.
    This creates smooth motion between the angles.

    The angles are translated to 3d vectors (relative to the origin 0,0,0), which represent the arms.

    The green vectors mark the start of the swimming gait.
    The blue vector marks the axis of forward motion (along the displayed x-y plane).
    The red vectors positioned on the blue sphere are the creature.
    '''

    # create in between motion for the angles for better animation of a complete swimming gait trajectory
    # first add the first 2 angles to the end to create a complete swimming stroke
    angles = list(angles) + [angles[0],angles[1]]

    # in between each point, add time_step angles
    more_angles = []
    for i in range(0,len(angles)-3,2):
        # the change in angley and angle z at each subsequent angle
        deltay = (angles[i+2] - angles[i])/time_step
        deltaz = (angles[i+3] - angles[i+1])/time_step

        # beginning of this particular part of the trajectory
        starty = angles[i]
        startz = angles[i+1]

        # building the trajectory time_step in length
        for t in range(time_step):
            more_angles += [ starty + t*deltay, startz + t*deltaz ]
            
            
    # translate each angle to a point [x,y,z] that is the endpoint (finger) relative to the origin (shoulder)
    positions = []
    for i in range(0,len(more_angles),2):
        positions.append(calc_position(more_angles[i],more_angles[i+1]))

    # Define the origins of the vectors (i.e. right and left arm)
    origin = [0, 0, 0]
    opposite_origin = [-1,0,0]

    # Create the figure and axes object
    fig = plt.figure(figsize=(10, 10))
    ax = fig.add_subplot(111, projection='3d')

    # Initialize quiver plot with placeholder data (claude did this. is it necessary?)
    #quiver = ax.quiver(*origin, 0,5,0, color='r')

    # Set the axis limits
    max_val = arm_length*2
    ax.set_xlim([-max_val, max_val])
    ax.set_ylim([-max_val, max_val])
    ax.set_zlim([-max_val, max_val])

    # Set the axis labels
    ax.set_xlabel('X')
    ax.set_ylabel('Y')
    ax.set_zlabel('Z')
    ax.set_title('Swimming Gait Animation')


    def plot_xy_plane(ax, z_height=0):
        # draw a transparent x-y plane
        xx, yy = np.meshgrid(np.linspace(-max_val, max_val, 10), 
                             np.linspace(-max_val, max_val, 10))
        
        # z values are all the same to create a flat plane
        zz = np.ones_like(xx) * z_height
        
        # Plot the plane
        ax.plot_surface(xx, yy, zz, color='g', alpha=0.3, rstride=1, cstride=1)


    def plot_sphere(ax, center, radius, color='b'):
        # draw the sphere (that is the creature's body)
        u = np.linspace(0, 2 * np.pi, 20)
        v = np.linspace(0, np.pi, 20)
        
        x = center[0] + radius * np.outer(np.cos(u), np.sin(v))
        y = center[1] + radius * np.outer(np.sin(u), np.sin(v))
        z = center[2] + radius * np.outer(np.ones(np.size(u)), np.cos(v))
        
        # Plot the sphere
        ax.plot_surface(x, y, z, color=color, alpha=0.7, rstride=2, cstride=2)


    def update(frame):
        # redrawn at each frame update
        
        ax.clear()  # Clear previous frame
        
        # Set up the axes again
        ax.set_xlim([-max_val, max_val])
        ax.set_ylim([-max_val, max_val])
        ax.set_zlim([-max_val, max_val])
        ax.set_xlabel('X')
        ax.set_ylabel('Y')
        ax.set_zlabel('Z')

        vectors = positions
        
        # Get current vector based on frame number and its opposite (the arms)
        current_vector = vectors[frame % len(vectors)]
        opposite_vector = [ -current_vector[0], current_vector[1], current_vector[2] ]

        start_vector = vectors[0]
        start_opposite = [ -start_vector[0], start_vector[1], start_vector[2] ]


        # frame is cleared so need to redraw
        plot_xy_plane(ax,z_height=0)
        plot_sphere(ax,[-0.5,0,0], radius=0.5,color='blue')

        # axis of forward motion
        ax.quiver(-0.5,0,0, 0,-10,0, color='b')

        # starting position of the swimming gait
        ax.quiver(*origin, *start_vector, color='g')
        ax.quiver(*opposite_origin, *start_opposite, color='g')
        
        # draw the next position of the arms
        ax.quiver(*origin, *current_vector, color='r', label=f'Vector: {current_vector}')
        ax.quiver(*opposite_origin, *opposite_vector, color='r', label=f'Vector: {current_vector}')

        ax.set_title(f'Vector: {current_vector}')
        ax.legend()
        
        return ax

    # Animation at interval frame rate (e.g. 100ms)
    ani = FuncAnimation(fig, update, frames=len(more_angles), interval=100, blit=False, repeat=True)

    # things claude told me to do.
    plt.tight_layout()
    plt.show()

