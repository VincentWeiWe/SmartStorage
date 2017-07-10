/**************************************************************************************************
  Filename:       Sound.h
  Revised:        $Date: 2012-02-12 15:58:41 -0800 (Sun, 12 Feb 2012) $
  Revision:       $Revision: 29216 $

  Description:    This file contains the Generic Application definitions.


  Copyright 2004-2012 Texas Instruments Incorporated. All rights reserved.

  IMPORTANT: Your use of this Software is limited to those specific rights
  granted under the terms of a software license agreement between the user
  who downloaded the software, his/her employer (which must be your employer)
  and Texas Instruments Incorporated (the "License"). You may not use this
  Software unless you agree to abide by the terms of the License. The License
  limits your use, and you acknowledge, that the Software may not be modified,
  copied or distributed unless embedded on a Texas Instruments microcontroller
  or used solely and exclusively in conjunction with a Texas Instruments radio
  frequency transceiver, which is integrated into your product. Other than for
  the foregoing purpose, you may not use, reproduce, copy, prepare derivative
  works of, modify, distribute, perform, display or sell this Software and/or
  its documentation for any purpose.

  YOU FURTHER ACKNOWLEDGE AND AGREE THAT THE SOFTWARE AND DOCUMENTATION ARE
  PROVIDED 揂S IS?WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED, 
  INCLUDING WITHOUT LIMITATION, ANY WARRANTY OF MERCHANTABILITY, TITLE, 
  NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT SHALL
  TEXAS INSTRUMENTS OR ITS LICENSORS BE LIABLE OR OBLIGATED UNDER CONTRACT,
  NEGLIGENCE, STRICT LIABILITY, CONTRIBUTION, BREACH OF WARRANTY, OR OTHER
  LEGAL EQUITABLE THEORY ANY DIRECT OR INDIRECT DAMAGES OR EXPENSES
  INCLUDING BUT NOT LIMITED TO ANY INCIDENTAL, SPECIAL, INDIRECT, PUNITIVE
  OR CONSEQUENTIAL DAMAGES, LOST PROFITS OR LOST DATA, COST OF PROCUREMENT
  OF SUBSTITUTE GOODS, TECHNOLOGY, SERVICES, OR ANY CLAIMS BY THIRD PARTIES
  (INCLUDING BUT NOT LIMITED TO ANY DEFENSE THEREOF), OR OTHER SIMILAR COSTS.

  Should you have any questions regarding your right to use this Software,
  contact Texas Instruments Incorporated at www.TI.com. 
**************************************************************************************************/

#ifndef Sound_H
#define Sound_H

#ifdef __cplusplus
extern "C"
{
#endif

/*********************************************************************
 * INCLUDES
 */
#include "ZComDef.h"

/*********************************************************************
 * CONSTANTS
 */

// These constants are only for example and should be changed to the
// device's needs
#define Sound_ENDPOINT           10

#define Sound_PROFID             0x0F04
#define Sound_DEVICEID           0x0001
#define Sound_DEVICE_VERSION     0
#define Sound_FLAGS              0

#define Sound_MAX_CLUSTERS       1
#define Sound_CLUSTERID          6
  
#define Double_MAX_CLUSTERS       8   //新加的双向通信的ID号
#define Double_CLUSTERID          3

// Send Message Timeout
#define Sound_SEND_MSG_TIMEOUT   3000     // Every 5 seconds
  

// Application Events (OSAL) - These are bit weighted definitions.
#define Sound_SEND_MSG_EVT       0x0001
  
  
/////////////////////////////////////////////////////////////  
#define SOUNDMEASUREMENT_EVT       0x0001
  
#define SOUNDMEASUREMENT_TIMEOUT   4000

#if defined( IAR_ARMCM3_LM )
#define Sound_RTOS_MSG_EVT       0x0002
#endif  

/*********************************************************************
 * MACROS
 */

/*********************************************************************
 * FUNCTIONS
 */

/*
 * Task Initialization for the Generic Application
 */
extern void Sound_Init( byte task_id );

//extern void SoundMeasurement_Init( byte task_id );

/*
 * Task Event Processor for the Generic Application
 */
extern UINT16 Sound_ProcessEvent( byte task_id, UINT16 events );

//extern UINT16 SoundMeasurement_ProcessEvent( byte task_id, UINT16 events );

///////////////////////////////////////////////////////////////////////

/*********************************************************************
*********************************************************************/

#ifdef __cplusplus
}
#endif

#endif /* Sound_H */
