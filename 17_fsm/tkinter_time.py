import tkinter as tk
from tkinter import font

# thanks claude

# states
WAIT = 0
ADJUST_HOUR = 1
ADJUST_MINUTE = 2

class TimeApp:
    def __init__(self, root):

        # set up the application
        self.root = root
        self.root.title("Time and Date App")
        self.root.geometry("400x300")
        self.root.configure(bg="#f0f0f0")

        self.state = WAIT

        # Current datetime and display mode
        self.hours = 0
        self.minutes = 0

        # Create fonts
        self.title_font = font.Font(family="Arial", size=14, weight="bold")
        self.display_font = font.Font(family="Arial", size=36, weight="bold") 
        self.button_font = font.Font(family="Arial", size=18, weight="bold")

        # Create frames
        self.display_frame = tk.Frame(root, bg="#f0f0f0", pady=20)
        self.display_frame.pack()

        self.buttons_frame = tk.Frame(root, bg="#f0f0f0", pady=8)
        self.buttons_frame.pack(fill="x")

        # Create display label for HH:MM
        self.hours_label = tk.Label(
            self.display_frame,
            text="HH",
            font=self.display_font,
            bg="#dad7cd",
            fg="#3A5A40"
        )
        self.hours_label.grid(row=0, column=0)

        self.colon_label = tk.Label(
            self.display_frame,
            text=":",
            font=self.display_font,
            bg="#dad7cd",
            fg="#3A5A40"
        )
        self.colon_label.grid(row=0, column=1)

        self.minutes_label = tk.Label(
            self.display_frame,
            text="MM",
            font=self.display_font,
            bg="#dad7cd",
            fg="#3A5A40"
        )
        self.minutes_label.grid(row=0, column=2)

        # Create buttons for setting time, +/- hours or minutes
        button_configs = [
            {
                "text": "Time",
                "command": self.time_pressed,
                "bg": "#a3b18a",
                "fg": "black"
            },
            {
                "text": "+",
                "command": self.plus_pressed,
                "bg": "#a3b18a",
                "fg": "black"
            },
            {
                "text": "-",
                "command": self.minus_pressed,
                "bg": "#a3b18a",
                "fg": "black"
            }

        ]

        for config in button_configs:
            button = tk.Button(
                self.buttons_frame,
                text=config["text"],
                command=config["command"],
                font=self.button_font,
                bg=config["bg"],
                fg=config["fg"],
                width=8,
                height=2,
                relief=tk.RAISED,
                bd=3
            )
            button.pack(side=tk.LEFT, padx=5)

        # Update display
        self.update_display()
        
        # Set up auto-refresh for real-time mode
        self.refresh_display()

    def update_display(self):
        #TODO - update these values using the actual hours and minute
        self.hours_label.config(text="00")
        self.colon_label.config(text=":")
        self.minutes_label.config(text="00")

    def convert(self,value):
        # convert the value to a 2-digit string: 4->"04"
        if value < 10:
            return "0"+str(value)
        else:
            return str(value)


    def plus_pressed(self):
        """Increment time or date based on current mode"""
        pass


    def minus_pressed(self):
        """Decrement time or date based on current mode"""
        pass

    def time_pressed(self):
        self.state = (self.state+1)%3
        # set up for the next state
        # if transitioning to setting hours, modify the color
        self.hours_label.config(fg="#778da9")
    
        
    def refresh_display(self):
        # if you feel inspired, you can count up/down the time
        
        # Schedule the next update
        self.root.after(1000, self.refresh_display)

if __name__ == "__main__":
    root = tk.Tk()
    app = TimeApp(root)
    root.mainloop()
