import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import screen01 from './screens/screen01';  
import screen02 from './screens/screen02'; 
const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
   <Stack.Navigator initialRouteName="Screen01">
  <Stack.Screen name="Screen01" component={screen01} />
  <Stack.Screen name="Screen02" component={screen02} />
</Stack.Navigator>

    </NavigationContainer>
  );
}
